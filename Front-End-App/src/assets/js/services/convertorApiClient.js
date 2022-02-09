export const convertorApiClient = (() => {
    const urlAPI = 'https://calcapp-backend.herokuapp.com/api/v1';

    return {
        convertToCelsius: async farenheit => {
            const response = await fetch(`${urlAPI}/celsius/${farenheit}`, {
                method: 'GET',
                headers: {
                  'Content-Type': 'application/json'
                }
            });
            return response.json();
        }, 

        convertToFarenheit: async celsius => {
            const response = await fetch(`${urlAPI}/fahrenheit/${celsius}`, {
                method: 'GET',
                headers: {
                  'Content-Type': 'application/json'
                }
            });
            return response.json();
        },
    };
})();
