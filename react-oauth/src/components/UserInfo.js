import { useState, useEffect } from 'react';
const UserInfo = () => {
    const [demoStr, setDemoStr] = useState('default');
    useEffect(() => {
        const urlToFetchUsers = 'http://localhost:8080/userinfo';
        const headers2 = new Headers();
        const access_token = sessionStorage.getItem('access_token')
        // headers2.append('Content-type', 'plain/text');
        headers2.append('Authorization', `Bearer ${access_token}`);
        fetch(urlToFetchUsers, {
            method: 'GET',
            mode: 'cors',
            headers2
        }).then(async (userData) => {
            const demo = await userData.text();
            setDemoStr(demo);
        })
    }, []);
    return <>
        <div className="header">
            <h1>UserInfo</h1>
        </div>
        <div>
            <p>{demoStr}</p>
        </div>
    </>;
}

export default UserInfo;