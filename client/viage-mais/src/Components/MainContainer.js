import Header from "./Header"

const MainContainer = ({ children }) => {
  return (
    <div>
      <Header />
      {children}
    </div>
  )
}

export default MainContainer