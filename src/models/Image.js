function mysql(sequelize, Sequelize) {
  return sequelize.define('image', {
    id: Sequelize.INTEGER(11),
    gallery_id: Sequelize.INTEGER(11),
    filename: Sequelize.STRING(255),
    alt: Sequelize.STRING(255),
  }, {
    tableName: 'images'
  });
}

function mongoDb(mongoose) {
  var imageSchema = new mongoose.Schema({
    id: Number,
    gallery_id: Number,
    filename: String,
    alt: String
  });
  
  return mongoose.model('image', imageSchema);
}

module.exports = {
  mysql: mysql,
  mongoDb: mongoDb
};