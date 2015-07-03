module.exports = function(sequelize, Sequelize) {
    return sequelize.define('gallery', {
        id: Sequelize.INTEGER(11),
        cover_id: Sequelize.INTEGER(11),
        title: Sequelize.STRING(60),
        slug: Sequelize.STRING(128),
    }, {
        tableName: 'galleries'
    });
}