import React from 'react'

function Card({ data }) {
  return (
    <div className="card ">
      <div className="card-image ">
        <img src={data.imgUrl} alt="hotel rio" />
      </div>
      <div className="card-content">
        <div className="hotel-name">
          <h3>Nome fictício</h3>
          <span>
            <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/star.svg" alt="" />
            <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/star.svg" alt="" />
            <img src="https://raw.githubusercontent.com/LeandroNcosta/ViageMais/main/images/star.svg" alt="" />
          </span>
        </div>
        <div className="avaliacoes">
          <span>5,0/5</span>
          <span>50 avaliações</span>
        </div>
        <span className="price">Apartir De R$ 999</span>
      </div>
    </div>
  )
}

export default Card