function mysql(sequelize, Sequelize) {
  return sequelize.define('gallery', {
    id: Sequelize.INTEGER(11),
    cover_id: Sequelize.INTEGER(11),
    title: Sequelize.STRING(60),
    slug: Sequelize.STRING(128),
  }, {
    tableName: 'galleries'
  });
}

function mongoDb(mongoose){
  var gallerySchema = new mongoose.Schema({
   id: Number,
   cover_id: Number,
   title: String,
   slug: String
  });
  
  return mongoose.model('gallery', gallerySchema);
}

module.exports = {
  mysql: mysql,
  mongoDb: mongoDb
};