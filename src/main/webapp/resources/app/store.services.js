/**
 * Created by ALEX on 8/14/2015.
 */
angular
    .module("storeApp")
    .factory("storeServices", storeServices);

function storeServices($resource) {
    return {
        salesServices: function (URL) {
            return $resource(URL, {}, {
                'get': {
                    method: 'GET',
                    headers: {'Authorization': 'Bearer 096fa935862e4c55db73e8f153ef867f'},
                    isArray: true // esto es temporal
                }
            })
        }
    };
}




