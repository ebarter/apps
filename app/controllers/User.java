package controllers;

import database.Connection.Connect;
import database.Connection.Connection;
import database.dao.impl.UserImpl;
import enums.Database;
import httpactions.ApiAuth;
import mapper.Mapper;
import play.mvc.BodyParser;
import play.mvc.Result;
import utils.Body;

import static play.mvc.Controller.request;
import static play.mvc.Results.status;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */

@ApiAuth
public class User {
    @Connect(
            database = Database.POSTGRESQL,
            host = "ec2-23-23-173-30.compute-1.amazonaws.com",
            databaseName = "d87s2lf0vv7l32",
            userName = "ppxiknjbrpshfp",
            password = "dadde9e960e7acc54bf9b09a35ef98f4ec01a149e1560b4a8c4f6909271cc76c",
            port = "5432"
    )
    public static Result testLogin(String nip, String password, int supervisor) {
        try {
            UserImpl userImpl = new UserImpl();
            model.User result = userImpl.getUserByNip(nip);
//            List<model.User> result = userImpl.select(new model.User(), "nip=? and password=? and supervisor=?", new Object[]{nip, password, supervisor});
            Connection.disconnect();
            if (result != null) {
                return Body.echo(enums.Result.RESPONSE_NOTHING, "User Found NIP : " + result.getNip());
            } else {
                return Body.echo(enums.Result.RESPONSE_NOTHING, "User Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Connection.disconnect();
            return status(401, e.getMessage());
        }
    }

    @Connect(
            database = Database.POSTGRESQL,
            host = "ec2-23-23-173-30.compute-1.amazonaws.com",
            databaseName = "d87s2lf0vv7l32",
            userName = "ppxiknjbrpshfp",
            password = "dadde9e960e7acc54bf9b09a35ef98f4ec01a149e1560b4a8c4f6909271cc76c",
            port = "5432"
    )
    public static Result testDelete(String nip) {
        try {
            UserImpl userImpl = new UserImpl();
            int result = userImpl.deleteByNip(nip);
//            List<model.User> result = userImpl.select(new model.User(), "nip=? and password=? and supervisor=?", new Object[]{nip, password, supervisor});
            Connection.disconnect();
            return Body.echo(enums.Result.REQUEST_OK, "User Found NIP : " + result);
        } catch (Exception e) {
            e.printStackTrace();
            Connection.disconnect();
            return status(401, e.getMessage());
        }
    }

    @Connect(
            database = Database.POSTGRESQL,
            host = "ec2-23-23-173-30.compute-1.amazonaws.com",
            databaseName = "d87s2lf0vv7l32",
            userName = "ppxiknjbrpshfp",
            password = "dadde9e960e7acc54bf9b09a35ef98f4ec01a149e1560b4a8c4f6909271cc76c",
            port = "5432"
    )
    @BodyParser.Of(value = BodyParser.Json.class , maxLength = 1024 * 1024 * 1024)
    public static Result testRegister() {
        try {
            final model.User body = new Mapper().toModel(request().body().asJson(), model.User.class);

            UserImpl userImpl = new UserImpl();
            userImpl.save(body);
            Connection.disconnect();

            return Body.echo(enums.Result.RESPONSE_NOTHING, "Inserting Success...");
        } catch (Exception e) {
            e.printStackTrace();
            Connection.disconnect();
            return status(401, e.getMessage());
        }
    }
}
