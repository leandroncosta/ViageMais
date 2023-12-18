import React from 'react';
import { useRouter } from 'next/router';

const RedirectToLogin = () => {
    const router = useRouter();

    React.useEffect(() => {
        router.push('/login');
    }, []);

    return null;
};

export default RedirectToLogin;
