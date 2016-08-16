(function () {
    'use strict';

    angular
        .module('movieflix')
        .controller('ReviewController', ReviewController);

    ReviewController.$inject = ['movieService', '$location'];

    function ReviewController(movieService, $location) {
        var reviewVm = this;

        reviewVm.createReview = createReview;

        init();

        function init() {
            console.log('Review Controller');
        }

        function createReview() {
            movieService
                .addReviewToMovie(reviewVm.review)
                .then(function () {
                    $location.path('/user/movies/'+reviewVm.review.movie.name);
                }, function (error) {
                    console.log(error);
                })
        }
    }
})();