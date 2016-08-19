(function () {
    'use strict';

    angular.module('movieflix')
        .controller('MoviesAdminController', MoviesAdminController);

    MoviesAdminController.$inject = ['movieService', '$location', '$route'];

    function MoviesAdminController(movieService, $location, $route) {
        var moviesAdminVm = this;

        moviesAdminVm.genres = [
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

        moviesAdminVm.selectedValue = '';

        moviesAdminVm.changeSort = changeSort;
        moviesAdminVm.addMovie = addMovie;
        moviesAdminVm.editRedirect = editRedirect;
        moviesAdminVm.delMovie = delMovie;

        init();

        function init() {

            moviesAdminVm.sorter = {
                by: 'title',
                reverse: false
            };

            movieService
                .getMovies()
                .then(function (movies) {
                    moviesAdminVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });

        }

        function editRedirect(title) {
            $location.path('/admin/editMovie/' + title);
        }

        function addMovie() {
            movieService
                .createMovie(moviesAdminVm.newMovie)
                .then(function () {
                    $location.path('/admin/movies');
                }, function (error) {
                    console.log(error);
                });

            moviesAdminVm.newMovie = {};
        }

        function delMovie(title) {
            movieService
                .deleteMovie(title)
                .then(function () {
                    $route.reload();
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            moviesAdminVm.sorter.by = prop;
            moviesAdminVm.sorter.reverse = !moviesAdminVm.sorter.reverse;
        }
    }
})();
