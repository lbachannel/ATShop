var app = angular.module("myapp", ["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/category", {
		templateUrl: "/assets/admin/layout/category.html"
	})
	.when("/product", {
		templateUrl: "/assets/admin/layout/product.html"
	})
	.when("/authority", {
		templateUrl: "/assets/admin/layout/authority.html"
	})
	.otherwise({
		redirectTo: ""
	});
});

app.run(function ($rootScope) {
    $rootScope.$on('$routeChangeStart', function () {
        $rootScope.loading = true;
    });
    $rootScope.$on('$routeChangeSuccess', function () {
        $rootScope.loading = false;
    });
    $rootScope.$on('$routeChangeError', function () {
        $rootScope.loading = false;
        alert("Lỗi");
    });
});