import { UserStorage } from '@/store/userContext';
import Header from './Header';

const MainContainer = ({ children }) => {
    return (
        <UserStorage>
            <Header />
            {children}
        </UserStorage>
    );
};

export default MainContainer;
