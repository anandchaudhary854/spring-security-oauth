import { useEffect } from "react";
import { useSearchParams, useNavigate } from "react-router-dom";
import { Buffer } from "buffer";
const Redirect = () => {
    const [searchParams] = useSearchParams();
    const navigate = useNavigate();
    useEffect(() => {
        console.log(searchParams?.get('code'), "code")
        if(searchParams?.get('code')){
            const code = searchParams?.get('code');
            const client = 'client';
            const secret = 'secret';
            const headers = new Headers();
            headers.append('Authorization', `Basic ${Buffer.from(`${client}:${secret}`).toString('base64')}`);
            let formData = new FormData()
            formData.append('client_id', 'client')
            formData.append('redirect_uri', 'http://127.0.0.1:3000/authorized')
            formData.append('grant_type', 'authorization_code')
            formData.append('code', code)
            const initialUrl = 'http://localhost:8080/oauth2/token'
            const url = `${initialUrl}`;

            fetch(url, {
                method: 'POST',
                mode: 'cors',
                body: formData,
                headers
            }).then(async (response) => {
                const token = await response.json();
                if(token?.id_token) {
                    sessionStorage.setItem('id_token', token.id_token);
                    sessionStorage.setItem('access_token', token.access_token)
                    navigate('/home');
                }
            }).catch((err) => {
                console.log(err);
            })
        }else{
            const link = `http://localhost:8080/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=http://127.0.0.1:3000/authorized`;
          
            window.location.href = link;
        }
    }, []);
    return <p>Redirecting ...</p>
}

export default Redirect;