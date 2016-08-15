(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('SignupController', SignupController);

    SignupController.$inject = ['signupService', '$location'];

    function SignupController(userService, $location) {
        var signupVm = this;

        signupVm.addUser = addUser;

        init();

        function init() {
            console.log('SignupController');
        }

        userService
            .addUser(addUserVm.newUser)
            .then(function (data) {
                $location.path('/login');
            }, function (error) {
                console.log(error);
            })
    }
})();