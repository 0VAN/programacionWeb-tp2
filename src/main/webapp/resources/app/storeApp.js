/**
 * Created by ALEX on 8/14/2015.
 */

angular
    .module('storeApp', [
        'ngResource',
        'ngRoute'])
    .controller('listSalesController', listSalesController);

function listSalesController() {


    var vm = this;
    vm.listConfig = {
        columns: [
            {name: 'Numero', property: 'numero', search: 'numero', visible: true, sortable: true, searchable: true},
            {name: 'Monto total', property: 'montoTotal', search: 'monto_total', visible: true, sortable: true, searchable: true},
            {name: 'Nombre del cliente', property: 'nombreCliente', search: 'nombre_cliente', visible: true, sortable: true, searchable: true},
            {name: 'RUC del cliente', property: 'rucCliente', search: 'ruc_cliente', visible: true, sortable: false, searchable: true},
            {name: 'Fecha', property: 'fecha', search: 'fecha', visible: true, sortable: true, searchable: true}
        ],
        URL: 'http://localhost:8080/restService/service/ventas',
        globalSearch: true,
        title: 'Lista de ventas',
        detailViewTitle: 'Vista detalle de venta'
    };
}