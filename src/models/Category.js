function mysql(sequelize, Sequelize) {
  return sequelize.define('category', {
    id: Sequelize.INTEGER(11),
    title: Sequelize.STRING(60),
    slug: Sequelize.STRING(128),
    subtitle: Sequelize.STRING(60),
    description: Sequelize.TEXT
  }, {
    tableName: 'categories'
  });
}

function mongoDb(mongoose){
  var categorySchema = new mongoose.Schema({
    id: Number,
    title: String,
    slub: String,
    subtitle: String,
    description: String
  });
  
  return mongoose.model('category', categorySchema);
}

module.exports = {
  mysql: mysql,
  mongoDb: mongoDb
};