import Header from './Header';

const MainContainer = ({ children }) => {
    return (
        <>
            <Header />
            {children}
        </>
    );
};

export default MainContainer;
