/**
 * Created by user on 8/28/16.
 */

 function AppController($scope, otcDynamic, testPlans, TestCases, TestPlans, Tester){
    var self = this
    $scope.loading = false
    $scope.conf = {
        deviceName:"",
        platformVersion:"",
        path:""
    }
    angular.forEach(testPlans, function(testPlan, index){
                        testPlan.tested = false;
                        angular.forEach(testPlans.tests, function(test, index){
                            test.tested = false
                        })
                    })
    var loading={
             show:function(){
                $scope.loading=true
                $scope.$apply
             },
             hide:function(){
                $scope.loading=false
                $scope.$apply
             }
        }
    class TestPlan {
      constructor(name, description,tests) {
        this.name = name;
        this.description = description;
        this.tests = tests
      }
    }
    class TestCase {
      constructor(name, description,input, output) {
              this.name = name
              this.description = description
              this.inp = input
              this.out = output
            }
    }
    function indexByName(name, arr){
        var i = 0;
        while(i<arr.length && arr[i].name!=name) i++
        if(i == arr.length) return -1
        else return i
    }
    $scope.testplans = testPlans
    self.createTestPlan = function(){
        var name = window.prompt("Enter testplans name...", "New TestPlan"+$scope.testplans.length)
        if(name != null&& name!="")
        if(indexByName(name, $scope.testplans) == -1){
            var tp = new TestPlan(name, "",[])
            $scope.testplans.push(tp)
            TestPlans.createOrUpdate(tp)
        } else alert("The Testplan with the same name already exists")
    }
    self.createTestCase = function(tp){
        var name = window.prompt("Enter testcases name...", "New test"+tp.tests.length)
        if(name != null&& name!="")
        if(indexByName(name, tp.tests) == -1){
            var tc = new TestCase(name, "","","")
            tp.tests.push(tc)
            TestCases.createOrUpdate(tc, tp.name)
        } else alert("The Testcase with the same name already exists")
    }
    self.saveTestCase = function(tc, name){
        TestCases.createOrUpdate(tc, name)
    }

    self.deleteTestCase = function(tc, tp){
            TestCases.delete(tc, tp)
        }
    self.runTestCase = function(tc){
        loading.show()
        var config = angular.fromJson($scope.config)
        var result = Tester.runTestCase(tc,config, function(res){
                                                        tc.tested = true
                                                        tc.res = res
                                                        loading.hide()
                                                     },loading.hide)
    }
    self.saveTestPlan = function(tp){
         TestPlans.createOrUpdate(tp)
    }
    self.deleteTestPlan = function(tp){

             TestPlans.delete(tp, $scope.testplans)
        }
    self.runTestPlan = function(tp){
        loading.show()
         var config = angular.fromJson($scope.config)
         Tester.runTestPlan(tp,config, function(results){
                                              tp.tested = true
                                              tp.res={result:true}
                                              var count = 0
                                              angular.forEach(tp.tests, function(test, index){
                                                   test.tested = true
                                                   test.res = results[index]
                                                   if(!results[index].result) tp.res={result:false}
                                                   else count++
                                              })
                                              tp.res.message = ""+count+"\\"+ tp.tests.length
                                              loading.hide()
                                            }, loading.hide)
    }
    self.openPanel = function (event) {
                var body = $(event.currentTarget).siblings(".panel-body");
                if (body.css('display') == 'none') {
                    body.show();
                }
                else {
                    body.hide();
                }
            };
}
AppController.resolve = {
    testPlans:function(TestPlans) {
            return TestPlans.query();
        }
}

