module.exports = function(sequelize, Sequelize) {
    var Project = sequelize.define('project', {
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
    
    return Project;
}