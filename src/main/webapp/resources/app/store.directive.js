/**
 * Created by alex on 19/08/15.
 */
angular
    .module('storeApp')
    .directive('listDirective', listDirective);

function listDirective() {
    return {
        templateUrl: 'resources/static/templates/list-directive.html',
        restrict: 'E',
        controller: 'listController',
        scope: {
            config: '='
        }
    };
}