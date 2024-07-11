const express = require('express');
const app = express();
const path = require('path');
const router = require('./router');

// Set the views directory and the view engine
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');


app.use(express.urlencoded({ extended: true }));


// Serve static files from the public folder
app.use(express.static(path.join(__dirname, 'public')));

// Add your routes and other middleware here
app.use('/', router);

// Start the server
app.listen(3000, () => {
  console.log('Server is running on port 3000');
});

