var restify = require('restify');
var Sequelize = require('sequelize');
var sequelize = new Sequelize('c9', 'pixelshaded', '', {
    define: {
        timestamps: false
    }
});

var Project = require('./src/models/Project')(sequelize, Sequelize);

var server = restify.createServer({
    name: 'portfolio-api',
    version: '1.0.0',
});

var host = process.env.IP;
var port = process.env.PORT;

server.use(restify.acceptParser(server.acceptable));
server.use(restify.queryParser());
server.use(restify.bodyParser());

server.get('/', function(req, res, next){
    Project.findAll().then(function(projects){
        res.send(projects);
        next();
    }, function(reason){
        res.send(reason);
        next();
    });
});

server.listen(port, host, function () {
    console.log('%s listening at %s', server.name, server.url);
});
