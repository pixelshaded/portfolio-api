module.exports = function(sequelize, Sequelize) {
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