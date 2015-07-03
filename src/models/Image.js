module.exports = function(sequelize, Sequelize) {
    return sequelize.define('image', {
        id: Sequelize.INTEGER(11),
        gallery_id: Sequelize.INTEGER(11),
        filename: Sequelize.STRING(255),
        alt: Sequelize.STRING(255),
    }, {
        tableName: 'images'
    });
}