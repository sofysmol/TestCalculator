/**
 * Created by user on 8/28/16.
 */
 function AppController($scope, otcDynamic, testPlans){
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
      save() {
      }
      run(){
      }
    }
    class TestCase {
      constructor(name, description,input, output) {
              this.name = name;
              this.description = description;
              this.input = input
              this.output = output
            }
            save() {
            }
            run(){
            }
    }
    $scope.testplans = testPlans
    self.createTestPlan = function(){
        var name = window.prompt("Enter testplans name...", "New TestPlan")
        $scope.testplans.push(new TestPlan(name, "",[]))
    }
    self.createTestCase = function(tp){
        var name = window.prompt("Enter testcases name...", "New test")
        tp.tests.push(new TestCase(name, "","",""))
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