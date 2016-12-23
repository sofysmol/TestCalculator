/**
 * Created by user on 8/28/16.
 */
var app = angular.module('clientApp', ['ngRoute','dataServices', 'ui.bootstrap',
                        'ui.bootstrap.tpls']);
app.config(function ($routeProvider) {
    $routeProvider
        .when('/',
            {
                templateUrl: "app/resources/templates/app.html",
                controller: AppController,
                controllerAs:'ctrl',
                resolve:AppController.resolve
            }
        )
});
app.directive("fileread", [function () {
        return {
            scope: {
                fileread: "="
            },
            link: function (scope, element, attributes) {
                element.bind("change", function (changeEvent) {
                    var reader = new FileReader();
                    reader.onload = function (loadEvent) {
                        scope.$apply(function () {
                            scope.fileread = loadEvent.target.result;
                        });
                    }
                    reader.readAsText(changeEvent.target.files[0]);
                });
            }
        }
    }]);
app.service("otcDynamic", function($compile)
{
    return function(templateUrl, scope)
    {
        var content = ""
        $.ajax({
            url: templateUrl,
            async: false,
            success: function (data) {
                var linkFn = $compile(data);
                content = linkFn(scope);
            }
        });
        return content
    }
});