/**
 * Created by alex on 19/08/15.
 */
angular
    .module('storeApp')
    .controller('listController', listController);

function listController($scope, storeServices) {

    var params = {};
    var sortIconsClass = ["circular inverted sort content icon ascending", "circular inverted sort content icon descending"];
    var sortIconsClassDisabled = ["sort content icon ascending", "sort content icon descending "];

    var selectedColumn = '';

    //var showLoadingModal = function (operation) {
    //    $('#loadingModal')
    //        .modal(operation)
    //    ;
    //};

    $scope.dataList = [];
    $scope.meta = {};
    $scope.page = 1;
    $scope.sortIconClass = sortIconsClass[0];
    $scope.sortIconClassDisabled = sortIconsClassDisabled[0];

    //showLoadingModal('show');
    storeServices.salesServices($scope.config.URL).get(function (serverResponse) {
        //$scope.dataList = serverResponse.ventas;
        //$scope.dataMeta = serverResponse.meta; con alexis
        $scope.respuesta = {
            ventas : serverResponse,
            meta : {
                "total": "200",
                "total_pages": "10",
                "page_size": "20"
            }
        };
        //showLoadingModal('hide');


        $scope.applyFilter = function (searchValue, column) {
            // showLoadingModal('show');

            if (searchValue != '') {
                params['by_' + column] = searchValue;
            }
            else {
                delete params['by_' + column];
            }
            storeServices.salesServices($scope.config.URL).get(params, function (serverResponse) {
                $scope.respuesta = {
                    ventas : serverResponse,
                    meta : {
                        "total": "200",
                        "total_pages": "10",
                        "page_size": "20"
                    }
                };
                //$scope.dataList = data.ventas;
                //$scope.dataMeta = data.meta;
                // showLoadingModal('hide');

            });
        };

        $scope.applySort = function (column) {
            //showLoadingModal('show');

            if (selectedColumn == column) {
                $scope.sortIconClass = $scope.sortIconClass == sortIconsClass[0] ? sortIconsClass[1] : sortIconsClass[0];
                params[selectedColumn] = $scope.sortIconClass == sortIconsClass[0] ? 'asc' : 'desc';
            }
            else {
                delete params[selectedColumn];
                selectedColumn = column;
                params[selectedColumn] = $scope.sortIconClass == sortIconsClass[0] ? 'asc' : 'desc';
            }
            storeServices.salesServices($scope.config.URL).get(params, function (serverResponse) {
                $scope.respuesta = {
                    ventas : serverResponse,
                    meta : {
                        "total": "200",
                        "total_pages": "10",
                        "page_size": "20"
                    }
                };
                //$scope.dataList = data.ventas;
                //$scope.dataMeta = data.meta;
                // showLoadingModal('hide');

            });
        };

        $scope.isThisColumnSelected = function (column) {
            return column == selectedColumn;
        };


        //Pagination methods
        $scope.checkNumberUp = function () {

            if ($scope.page != parseInt($scope.respuesta.meta.total_pages)) {
                return true;
            }

        };

        $scope.checkNumberDown = function () {

            if ($scope.page != 1) {
                return true;
            }

        };
        //Pagination methods

    });

    $scope.goBackPage = function () {
        //showLoadingModal('show');

        $scope.page -= 1;
        params.page = $scope.page;
        storeServices.salesServices($scope.config.URL).get(params, function (serverResponse) {
            $scope.respuesta = {
                ventas : serverResponse,
                meta : {
                    "total": "200",
                    "total_pages": "10",
                    "page_size": "20"
                }
            };
            //$scope.dataList = data.ventas;
            //$scope.dataMeta = data.meta;
            //showLoadingModal('hide');

        });

    };

    $scope.goNextPage = function () {
        //showLoadingModal('show');

        $scope.page += 1;
        params.page = $scope.page;
        storeServices.salesServices($scope.config.URL).get(params, function (serverResponse) {
            $scope.respuesta = {
                ventas : serverResponse,
                meta : {
                    "total": "200",
                    "total_pages": "10",
                    "page_size": "20"
                }
            };
            //$scope.dataList = data.ventas;
            //$scope.dataMeta = data.meta;
            //showLoadingModal('hide');

        });

    };

    $scope.showDetailsModal = function (data) {
        $scope.data = data;
        $('#detailModal')
            .modal('show')
        ;
    };


}