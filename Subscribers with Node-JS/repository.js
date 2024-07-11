class Repository {
    
    constructor() {
        this.seedRepo();
    }
    
    getCategories() {
        return this.categories;
    }
    getCategory(catName) {
        return this.categories.find(x => x.catName == catName);
    }
    subscribe(catName, nick, email) {
        let category = this.getCategory(catName);
        if (category && category.subs.find(x => x.nick == nick && x.email == email)){
            return 0;
        } else {
             category.subs.push({
                nick, email
             });
             return 1;
        }
    }
    /************ Seeding repo below: ****************/
    seedRepo() {
        this.categories = ['Outdoors', 'Sports', 'Pizzas', 'Woks', 'Politics', 'Technology', 'Pets', 'BBQ'];
        this.categories = this.categories.map(x => ({
            catName: x,
            subs: []
        }));
    }
}

module.exports = Repository;
