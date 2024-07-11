const express = require('express');
const router = express.Router();

// Import the repository instance
const repo = require('./repo');

// Define routes
router.get('/', function (req, res, next) {
  res.render('home', {
    title: 'Home',
    categories: repo.getCategories(),
  });
});

router.get('/:catName', function (req, res) {
  let category = repo.getCategory(req.params.catName);
  if (category) {
    res.render('subscribe', {
      title: 'Subscription',
      category: category.catName,
      err: '',
    });
  } else {
    res.status(404).send("Are you guessing?");
  }
});

router.post('/subscribe/:catName', function (req, res) {
  let count = repo.subscribe(req.params.catName, req.body.nick, req.body.email);
  if (count) {
    res.redirect('/');
  } else {
    res.render('subscribe', {
      title: 'Subscription',
      category: req.params.catName,
      err: `This nick and email (${req.body.nick || {}}, ${req.body.email || {}}) combination is already subscribed.`,
    });
  }
});

router.get('/subscribe/:catName', function (req, res) {

    res.render('subscribe', {
      title: 'Subscription',
      category: req.params.catName,
      err: ''
    });
  
});

module.exports = router;

