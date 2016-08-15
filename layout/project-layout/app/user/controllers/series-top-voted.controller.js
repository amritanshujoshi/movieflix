(function () {
    'use strict';

    angular.module('movieflix')
        .controller('SeriesTopVotedController', SeriesTopVotedController);

    SeriesTopVotedController.$inject = ['movieService'];

    function SeriesTopVotedController(movieService) {
        var seriesTopVotedVm = this;

        seriesTopVotedVm.changeSort = changeSort;

        init();

        function init() {

            seriesTopVotedVm.sorter = {
                by: 'title',
                reverse: false
            };

            movieService
                .getTopVotedSeries()
                .then(function (movies) {
                    seriesTopVotedVm.movies = movies;
                }, function (error) {
                    console.log(error);
                });
        }

        function changeSort(prop) {
            seriesTopVotedVm.sorter.by = prop;
            seriesTopVotedVm.sorter.reverse = !seriesTopVotedVm.sorter.reverse;
        }
    }
})();
