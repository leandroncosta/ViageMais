const GET_DESTINATION = {
    url: 'http://localhost:8080/api/destination',
    options: {
        headers: {
            Authorization: 'Bearer ' + window.localStorage.getItem('token'),
        },
    },
};
