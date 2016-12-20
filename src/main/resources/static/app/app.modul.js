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