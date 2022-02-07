export const convertorApiClient = (() => {
    const urlAPI = 'https://calcapp-backend.herokuapp.com/api/v1';

    return {
        convertToCelsius: async farenheit => {
            return await fetch(`${urlAPI}/celsius/${farenheit}`).then(
                response => {
                    return response.json();
                },
            );
        },

        convertToFarenheit: async celsius => {
            return await fetch(`${urlAPI}/fahrenheit/${celsius}`).then(
                response => {
                    return response.json();
                },
            );
        },
    };
})();
