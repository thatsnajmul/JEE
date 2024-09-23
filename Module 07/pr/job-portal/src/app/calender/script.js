document.addEventListener('DOMContentLoaded', () => {
    const days = document.querySelectorAll('.calendar-day');
    const today = new Date().getDate();
    
    days.forEach(day => {
        if (parseInt(day.textContent) === today) {
            day.classList.add('current-day');
        }
    });
});
