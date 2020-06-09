function mysql(sequelize, Sequelize) {
  return sequelize.define('project', {
    id: Sequelize.INTEGER(11),
    category_id: Sequelize.INTEGER(11),
    gallery_id: Sequelize.INTEGER(11),
    title: Sequelize.STRING(60),
    slug: Sequelize.STRING(128),
    subtitle: Sequelize.STRING(60),
    tagline: Sequelize.STRING(100),
    intro: Sequelize.TEXT,
    content: Sequelize.TEXT,
    subcontent: Sequelize.TEXT
  });
}

function mongoDb(mongoose){
  var projectSchema = new mongoose.Schema({
    id: Number,
    category_id: Number,
    gallery_id: Number,
    title: String,
    slug: String,
    subtitle: String,
    tagline: String,
    intro: String,
    content: String,
    subcontent: String
  });
  
  return mongoose.model('project', projectSchema);
}

module.exports = {
  mysql: mysql,
  mongoDb: mongoDb
};