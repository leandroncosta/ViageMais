import ProtectedRouter from '@/Components/Helper/ProtectedRoute';
import { userContext } from '@/store/userContext';
import React from 'react';

const userProfile = () => {
    const { user, setUser, setLogin } = React.useContext(userContext);

    const handleClick = () => {
        setUser('');
        setLogin(false);
    };

    return (
        <ProtectedRouter>
            <div className="container w-25 d-flex flex-column justify-content-center mt-4">
                <h1>Perfil</h1>
                <p>Usuário: {user.username}</p>
                <button
                    onClick={handleClick}
                    className="bg-danger p-2  rounded w-25">
                    Logout
                </button>
            </div>
        </ProtectedRouter>
    );
};

export default userProfile;
