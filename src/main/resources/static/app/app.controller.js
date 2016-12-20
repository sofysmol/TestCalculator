/**
 * Created by user on 8/28/16.
 */
 function AppController($scope, otcDynamic, testPlans){
    var self = this
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