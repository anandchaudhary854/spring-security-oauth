import { React } from 'react';
import { Link } from 'react-router-dom';
const Login = () => {
    return (
        <>
            <Link to={'/redirect'}>Login</Link>
        </>
    );
}

export default Login;