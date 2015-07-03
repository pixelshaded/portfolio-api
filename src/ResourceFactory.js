module.exports = function(server, Resource) {
    function isStringType(type){
      return type.key == 'TEXT' || type.key == 'STRING';
    }
    
    server.get(Resource.name, function(req, res, next) {
      var where = {};
      
      for(var param in req.query) {
        if (Resource.attributes[param]) {
          if (isStringType(Resource.attributes[param].type)) {
            where[param] = {
                $like: '%' + req.query[param] + '%'
            };
          } else {
            where[param] = req.query[param];
          }
        }
      }
      
      if (where != {}){
        Resource.findAll({ where: where }).then(function(resources) {
          res.send(resources);
          next();
        }, function(reason) {
          res.send(reason);
          next();
        });
        return;
      }
      
      Resource.findAll().then(function(resources) {
        res.send(resources);
        next();
      }, function(reason) {
        res.send(reason);
        next();
      });
    });
    
    server.get(Resource.name + '/:id', function(req, res, next) {
      Resource.findById(req.params.id).then(function(resource) {
        res.send(resource);
        next();
      }, function(reason) {
        res.send(reason);
        next();
      });
    });
}