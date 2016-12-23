/**
 * Created by user on 9/8/16.
 */
 String.prototype.format = function(...args) {
      let result = this.toString();
      let i = 0;
      for (let arg of args) {
           let strToReplace = "{" + i++ + "}";
           result = result.replace(strToReplace, (arg || ''));
      }
      return result;
 };
function makeArray(Type) {
    return function(response) {
        var list = [];
        angular.forEach(response.data, function(data) {
            list.push(new Type(data));
        });
        return list;
    }
}

function instantiate(Type) {
    return function(response) {
        return new Type(response.data);
    }
}

function remove(elem, arr){
    var index = arr.indexOf(elem)
    if(index!=-1)
        arr.splice(index,1)
}
angular.module('dataServices', [])
.factory('TestCases', function($http){
       var TestCases = function(data){
           angular.copy(data, this);
       };
       TestCases.query = function() {
           return $http.get('/testcases').then(makeArray(TestCases));
       };
       TestCases.createOrUpdate = function(testcase, name){
           return $http.put('/testcase', {test:testcase, nameTestPlan:name}).then(instantiate(TestCases))
       };
       TestCases.delete = function(testcase, testplan){
           return $http.delete('/testcase?name='+testcase.name+"&planName="+testplan.name).then(function(response){
                if(response.status == 200) {
                    remove(testcase, testplan.tests)
                }
                else alert("Can't delete item")
           })
       };
       return TestCases;
 })
.factory('TestPlans', function($http){
                var TestPlans = function(data){
                    angular.copy(data, this);
                };
                TestPlans.query = function() {
                    return $http.get('/testplans').then(makeArray(TestPlans));
                };
                TestPlans.createOrUpdate = function(testplan){
                    return $http.put('/testplan', testplan).then(instantiate(TestPlans))
                };
                TestPlans.delete = function(testplan, testplans){
                    return $http.delete('/testplan?name='+testplan.name).then(function(response){
                    if(response.status == 200){
                        remove(testplan, testplans)
                     }
                    else alert("Can't delete item")
                    })
                };
                return TestPlans;
   })
.factory('Tester', function($http){
        var Tester = function(data){
              angular.copy(data, this);
        };
        var ResultTest = function(data){
              angular.copy(data, this);
        };
        Tester.runTestCase = function(tc,config) {
              return $http.post('/runtestcase', {
                config:config,
                testCase:tc}).then(instantiate(ResultTest));
        };
        Tester.runTestPlan = function(tp){
                    return $http.post('/runtestplan', {
                     config:config,
                     testTestPlan:tp}).then(makeArray(ResultTest))
                };
        return Tester;
})