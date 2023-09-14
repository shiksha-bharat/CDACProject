import Login from './Auth/login';
import {Route} from 'react-router-dom';

function ProtectedRoute(props)
{
    var isLoggedIn = true;
    var isuserLoggedIn = true;
  var isuserLoggedIn = window.sessionStorage.getItem("isLoggedIn");
    if(isuserLoggedIn!=null && isuserLoggedIn=='true')
    {
      isLoggedIn = true;
    }
    else
    {
       isLoggedIn = false;
    }
 

    if(true)
    {
        return <Route exact path={props.path} 
                      component={props.component}/>
    }
    else
    {
        return <Login></Login>   
    }
}

export default ProtectedRoute;