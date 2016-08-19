(function () {
    'use strict';

    angular.module('movieflix')
        .controller('MovieEditController', MovieEditController);

    MovieEditController.$inject = ['movieService', '$location', '$routeParams'];

    function MovieEditController(movieService, $location, $routeParams) {
        var movieEditVm = this;

        movieEditVm.genres = [
            {value: 'Action', name: 'Action'}, {value: 'Adventure', name: 'Adventure'}, {
                value: 'Animation',
                name: 'Animation'
            },
            {value: 'Biography', name: 'Biography'}, {value: 'Comedy', name: 'Comedy'}, {value: 'Crime', name: 'Crime'},
            {value: 'Documentary', name: 'Documentary'}, {value: 'Drama', name: 'Drama'}, {
                value: 'Family',
                name: 'Family'
            },
            {value: 'Fantasy', name: 'Fantasy'}, {value: 'History', name: 'History'}, {value: 'Horror', name: 'Horror'},
            {value: 'Mystery', name: 'Mystery'}, {value: 'News', name: 'News'}, {value: 'Romance', name: 'Romance'},
            {value: 'Sci-Fi', name: 'Sci-Fi'}, {value: 'Talk-Show', name: 'Talk-Show'}, {
                value: 'Thriller',
                name: 'Thriller'
            },
            {value: 'War', name: 'War'}, {value: 'Western', name: 'Western'}];

        movieEditVm.editMovie = editMovie;

        init();

        function init() {

            movieService
                .getMovieByTitle($routeParams.title)
                .then(function (movie) {
                    movieEditVm.movie = movie;
                }, function (error) {
                    console.log(error);
                });

        }

        function editMovie() {
            movieService
                .editMovie(movieEditVm.movie)
                .then(function () {
                    $location.path('/admin/movies');
                }, function (error) {
                    console.log(error);
                });
        }
    }
})();