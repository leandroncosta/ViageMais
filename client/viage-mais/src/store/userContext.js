import { IMAGES_MANIFEST } from 'next/dist/shared/lib/constants';
import { useRouter } from 'next/router';
import React, { createContext } from 'react';

export const userContext = createContext();

export const UserStorage = ({ children }) => {
    const [user, setUser] = React.useState('');
    const [login, setLogin] = React.useState(false);
    const router = useRouter();

    const getUser = async (token) => {
        const response = await fetch(`http://localhost:8080/api/user/info`, {
            headers: {
                Authorization: 'Bearer ' + window.localStorage.getItem('token'),
            },
        });

        if (!response.ok) {
            router.push('/');
            return;
        }
        const json = await response.json();
        setUser('');
        setUser(json);
        setLogin(true);
        console.log(json);
    };

    const userLogin = async (login, password) => {
        try {
            const response = await fetch('http://localhost:8080/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    login,
                    password,
                }),
            });

            const json = await response.json();
            window.localStorage.setItem('token', json.token);

            if (json.token) {
                getUser(json.token);
            }
            return json;
        } catch (e) {
        } finally {
        }
    };

    const logout = () => {};

    React.useEffect(() => {
        const autoLogin = async () => {
            if (window.localStorage.getItem('token')) getUser('');
        };

        autoLogin();
    }, []);

    return (
        <userContext.Provider
            value={{ userLogin, login, user, setUser, setLogin }}>
            {children}
        </userContext.Provider>
    );
};
