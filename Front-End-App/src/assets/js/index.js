import { convertorApiClient } from './services/convertorApiClient.js';

//========================Variables========================
var formValues;

const inputCelsius = document?.getElementById('celsius');
const inputFahrenheit = document?.getElementById('fahrenheit');
const btnLimpiar = document?.getElementById('btn-limpiar');
const btnDoc = document?.getElementById('btn-doc');

const inputs = [
    ['celsius', inputCelsius],
    ['farenheit', inputFahrenheit],
];
//========================Functions========================

const celsiusFunction = event => {
    const { value } = event.target;
    updateValues('celsius', value);
    convertorApiClient.convertToFarenheit(value).then(response => {
        const { value } = response;
        updateInput('farenheit', value);
    });
};

const farenheitFunction = event => {
    const { value } = event.target;
    updateValues('farenheit', value);
    convertorApiClient.convertToCelsius(value).then(response => {
        const { value } = response;
        updateInput('celsius', value);
    });
};

const updateValues = (name, value) => {
    formValues = { ...formValues, [name]: value };
};

const updateInput = (name, value) => {
    updateValues(name, value);
    updateInputHTML();
};

const updateInputHTML = () => {
    inputs?.forEach(input => {
        input[1].value = formValues[input[0]];
    });
};

const clearValues = () => {
    formValues = { farenheit: '', celsius: '' };
};

const clearHTML = () => {
    clearValues();
    updateInputHTML();
};

export const redirect = page => {
    window.location = `/public/${page}`;
};

//========================EventsListeners==================

setEventsListeners();

// Function that set all the events of the DOM
function setEventsListeners() {
    document?.addEventListener('DOMContentLoaded', () => {
        clearHTML();
    });

    btnLimpiar?.addEventListener('click', clearHTML);

    btnDoc?.addEventListener('click', () => {
        redirect('documentation.html');
    });

    inputCelsius?.addEventListener('change', celsiusFunction);

    inputFahrenheit?.addEventListener('change', farenheitFunction);
}
