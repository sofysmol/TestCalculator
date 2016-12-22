/**
 * Created by user on 8/28/16.
 */
 function AppController($scope, otcDynamic, testPlans, TestCases, TestPlans){
    var self = this
    $scope.conf = {
        deviceName:"",
        platformVersion:"",
        path:""
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
    $scope.testplans = testPlans
    self.createTestPlan = function(){
        var name = window.prompt("Enter testplans name...", "New TestPlan")
        var tp = new TestPlan(name, "",[])
        $scope.testplans.push(tp)
        TestPlans.createOrUpdate(tp)
    }
    self.createTestCase = function(tp){
        var name = window.prompt("Enter testcases name...", "New test")
        var tc = new TestCase(name, "","","")
        tp.tests.push(tc)
        TestCases.createOrUpdate(tc, tp.name)
    }
    self.saveTestCase = function(tc){
        TestCases.createOrUpdate(tc)
    }
    self.deleteTestCase = function(tc){
            TestCases.delete(tc)
        }
    self.runTestCase = function(tc){

    }
    self.saveTestPlan = function(tp){
         TestPlans.createOrUpdate(tp)
    }
    self.deleteTestPlan = function(tp){
             TestPlans.delete(tp)
        }
    self.runTestPlan = function(tp){

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