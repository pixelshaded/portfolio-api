var restify = require('restify');
var Sequelize = require('sequelize');
var sequelize = new Sequelize('c9', 'pixelshaded', '', {
    define: {
        timestamps: false
    }
});

var server = restify.createServer({
    name: 'portfolio-api',
    version: '1.0.0',
});

var host = process.env.IP;
var port = process.env.PORT;

server.use(restify.acceptParser(server.acceptable));
server.use(restify.queryParser());
server.use(restify.bodyParser());

var resourceFactory = require('./src/ResourceFactory');
var resources = ['Project', 'Gallery', 'Category', 'Image'];

for(var i = 0; i < resources.length; i++){
    var Resource = require('./src/models/' + resources[i]).mysql(sequelize, Sequelize);
    resourceFactory(server, Resource, host, port);
}

server.listen(port, host, function () {
    console.log('%s listening at %s', server.name, server.url);
});
