document.getElementById('expenseForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission

    // Create an object to hold the form data
    const expenseData = {
        category: document.getElementById('category').value,
        amount: document.getElementById('amount').value,
        description: document.getElementById('description').value,
        date: document.getElementById('date').value
    };

    // Perform AJAX request to add the expense
    fetch('/api/expenses', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(expenseData)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Expense added:', data);
        // Handle success or update UI
        alert('Expense added successfully!');
        // Optionally, reset the form
        document.getElementById('expenseForm').reset();
    })
    .catch(error => {
        console.error('Error adding expense:', error);
        // Handle error or show message
        alert('Error adding expense. Please try again.');
    });
});