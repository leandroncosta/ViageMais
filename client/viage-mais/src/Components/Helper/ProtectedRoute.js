import React from 'react';
import { userContext } from '@/store/userContext';
import RedirectToLogin from './RedirectToLogin';
import { useRouter } from 'next/router';

const ProtectedRouter = ({ children }) => {
    const data = React.useContext(userContext);
    const isAuthenticated = data.user && data.login;
    const router = useRouter();

    React.useEffect(() => {
        if (!isAuthenticated) {
            router.push('/login');
        }
    }, []);

    return isAuthenticated ? <>{children}</> : <RedirectToLogin />;
};

export default ProtectedRouter;
