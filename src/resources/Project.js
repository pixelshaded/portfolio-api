module.exports = function(server, Project) {
    server.get('project', function(req, res, next){
        Project.findAll().then(function(projects){
            res.send(projects);
            next();
        }, function(reason){
            res.send(reason);
            next();
        });
    });
    
    server.get('project/:id', function(req, res, next){
        Project.findById(req.params.id).then(function(project){
            res.send(project);
            next();
        }, function(reason){
            res.send(reason);
            next();
        });
    });
}