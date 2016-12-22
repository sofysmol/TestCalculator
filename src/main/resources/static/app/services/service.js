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
angular.module('dataServices', [])
.factory('TestCases', function($http){
       var TestCases = function(data){
           angular.copy(data, this);
       };
       TestCases.query = function() {
           return $http.get('/testcases').then(makeArray(TestCases));
       };
       TestCases.createOrUpdate = function(testcase, name){
           return $http.put('/testcase', {test:testcase, nameTestPlan:name}).then(instantiate)
       };
       TestCases.delete = function(testcase, name){
           return $http.delete('/testcase?name='+testplan.name+"&planName="+name).then(instantiate)
       };
       return TestCases;
 }).factory('TestPlans', function($http){
                var TestPlans = function(data){
                    angular.copy(data, this);
                };
                TestPlans.query = function() {
                    return $http.get('/testplans').then(makeArray(TestPlans));
                };
                TestPlans.createOrUpdate = function(testplan){
                    return $http.put('/testplan', testplan).then(instantiate)
                };
                TestPlans.delete = function(testplan){
                    return $http.delete('/testplan?name='+testplan.name).then(instantiate)
                };
                return TestPlans;
   })