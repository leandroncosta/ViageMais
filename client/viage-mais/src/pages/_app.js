import MainContainer from '@/Components/MainContainer'
import '@/styles/globals.css'
import '@/styles/main.min.css'

export default function App({ Component, pageProps }) {
  return (
    <MainContainer>
      <Component {...pageProps} />
    </MainContainer>
  )
}
