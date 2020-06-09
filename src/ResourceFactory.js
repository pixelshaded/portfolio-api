module.exports = function(server, Resource) {
    function isStringType(type){
      return type.key == 'TEXT' || type.key == 'STRING';
    }
    
    function addLinksToResource(resource, req) {
      var ids = [];
      for(var property in resource) {
        if (resource[property] === null){
          continue;
        }
        var idIndex = property.indexOf('_id');
        if (idIndex != -1){
          var targetResource = property.split('_id')[0];
          if (!resource.links) {
            resource.links = [];
          }
          resource.links.push({
            rel: targetResource,
            href: 'http://' + req.header('host') + '/' + targetResource + '/' + resource[property]
          });
        }
      }
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
          for(var i = 0; i < resources.length; i++){
            resources[i] = resources[i].get({ plain: true});
            addLinksToResource(resources[i], req);
          }
          res.send(resources);
          next();
        }, function(reason) {
          res.send(reason);
          next();
        });
        return;
      }
      
      Resource.findAll().then(function(resources) {
        for(var i = 0; i < resources.length; i++){
          resources[i] = resources[i].get({ plain: true});
          addLinksToResource(resources[i], req);
        }
        res.send(resources);
        next();
      }, function(reason) {
        res.send(reason);
        next();
      });
    });
    
    server.get(Resource.name + '/:id', function(req, res, next) {
      Resource.findById(req.params.id).then(function(resource) {
        resource = resource.get({ plain: true});
        addLinksToResource(resource, req);
        res.send(resource);
        next();
      }, function(reason) {
        res.send(reason);
        next();
      });
    });
}