import { redirect } from './index.js';

//========================Variables========================
const btnVolver = document.getElementById('btn-volver');

//========================EventsListeners==================

setEventsListeners();

// Function that set all the events of the DOM
function setEventsListeners() {
    btnVolver?.addEventListener('click', () => {
        redirect('index.html');
    });
}
